let saveManufactureApi;
let addManufactureForm;
let manufactureTable;
$(document).ready(() => {
  saveManufactureApi = `${manufactureApi}/save`;
  addManufactureForm = $("#add-manufacture-form");
  initManufactureTableConfig();
  getAllManufactureData();
  addManufacture();
});

const initManufactureTableConfig = () => {
  manufactureTable = new DataTable("#manufacture-table", {
    responsive: true,
    columns: [
      {
        data: "id",
        className: "text-right",
        title: "ID",
        type: "string",
      },
      {
        data: "manufactureName",
        className: "text-right",
        title: "Manufacture Name",
        type: "string",
      },
      {
        data: "action",
        className: "text-right",
        title: "Action",
        type: "string",
      },
    ],
    columnDefs : manufactureDef()
  });
}
let generateManufactureTable = (manufactures) => {
    
  manufactureTable.clear().rows.add(manufactures).draw();
};

const getAllManufactureData = () => {
  let manufactures = [];
  showSpinner();
  httpGet(`${manufactureApi}/all`)
    .done((resp) => {
      let data = resp.data;
      if (data && data.length > 0) {
        data.forEach((x) => manufactures.push(new ManufactureModel(x)));
      }
      generateManufactureTable(manufactures);
      hideSpinner();
    })
    .fail(() => {
      generateManufactureTable([]);
      hideSpinner();
    });
};
const addManufacture = () => {
  $("#manufacture-add-btn").click(function (e) {
    e.preventDefault();
    showSpinner();
    let body = buildForm(addManufactureForm);
    body.id = null;
    let manufacture = new ManufactureModel(body);
    manufacture.validateAndSave(manufacture);
    hideSpinner();
  });
};

const manufactureDef = () => {
  return [{
    targets:2,
    render: (data) => {
      let editBtn = ``;
      let deleteBtn = ``;
      return `<div class="w-100 justify-content-center">${editBtn}${deleteBtn}</div>`
    }
  }];
};

class ManufactureModel {
  id;
  manufactureName;
  action;
  constructor({id,manufactureName}){
    this.id = id;
    this.manufactureName = manufactureName;
    this.action = {id,manufactureName}
  }
  getId(){
    return this.id;
  }
  getManufactureName(){
    return this.manufactureName;
  }
  setManufactureName(manufactureName){
    this.manufactureName = manufactureName;
  }

  validateField = () => {
    let isValid = true;
    if (!this.manufactureName) {
      warning("Missing field", "Manufacture name can not be empty");
      isValid = false;
    }
    return isValid;
  };

  validateAndSave = () => {
    if (this.validateField()) {
      confirmBox(
        "Add Manufacture !",
        "Do you want to add Manufacture",
        this.saveManufacture,
        this
      );
    }
  };

  saveManufacture = () => {
    if (this) {
      httpPost(this, saveManufactureApi).then((resp) => {
        if (resp) {
          successThenDo(resp.status, resp.message, getAllManufactureData);
          clearForm(addManufactureForm);
        }
      });
    }
  };
}