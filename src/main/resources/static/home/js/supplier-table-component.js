let saveSupplierApi;
let supplierTable;
$(document).ready(() => {
  saveSupplierApi = `${supplierApi}/save`;
  initSupplierTableConfig();
  addSupplier();
  getAllSupplierData();
});

const initSupplierTableConfig = () => {
  supplierTable = new DataTable("#suppliers-table", {
    responsive: true,
    columns: [
      {
        data: "id",
        className: "text-right",
        title: "ID",
        type: "string",
      },
      {
        data: "supplierName",
        className: "text-right",
        title: "Supplier Name",
        type: "string",
      },
      {
        data: "action",
        className: "text-right",
        title: "Action",
        type: "string",
      },
    ],
    columnDefs : supplierDef()
  });
}

let generateSupplierTable = (suppliers) => {
  supplierTable.clear().rows.add(suppliers).draw();
};

const getAllSupplierData = () => {
  let suppliers = [];
  showSpinner();
  httpGet(`${supplierApi}/all`)
    .done((resp) => {
      let data = resp.data;
      if (data && data.length > 0) {
        data.forEach((x) => suppliers.push(new Supplier(x)));
      }
      generateSupplierTable(suppliers);
      hideSpinner();
    })
    .fail(() => {
      generateSupplierTable([]);
      hideSpinner();
    });
};

const addSupplier = () => {
  $("#supplier-add-btn").click(function (e) {
    e.preventDefault();
    showSpinner();
    let body = buildForm("#supplier-form");
    validateAndSave(body);
    hideSpinner();
  });
};

const validateField = (body) => {
  let isValid = true;
  if (!body.supplierName) {
    warning("Missing field", "Supplier name can not be empty");
    isValid = false;
  }
  return isValid;
};

const validateAndSave = (body) => {
  if (validateField(body)) {
    confirmBox(
      "Add Supplier !",
      "Do you want to add supplier",
      saveSuppier,
      body
    );
  }
};

const saveSuppier = (body) => {
  console.log(body);
  if (body) {
    httpPost(body, saveSupplierApi).then((resp) => {
      if (resp) {
        successThenDo(resp.status, resp.message, getAllSupplierData);
        clearForm("#supplier-form");
      }
    });
  }
};

const supplierDef = () => {
  return [{
    targets:2,
    render: (data) => {
      let editBtn = ``;
      let deleteBtn = ``;
      return `<div class="w-100 justify-content-center">${editBtn}${deleteBtn}</div>`
    }
  }];
};
