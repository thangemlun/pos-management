let saveCategoryApi;
let addCategoryForm;
let categoryTable;
$(document).ready(() => {
  saveCategoryApi = `${categoryApi}/save`;
  addCategoryForm = $("#add-category-form");
  initCategoryTableConfig();
  getAllCategoryData();
  addCategory();
});

const initCategoryTableConfig = () => {
  categoryTable = new DataTable("#category-table", {
    responsive: true,
    columns: [
      {
        data: "id",
        className: "text-right",
        title: "ID",
        type: "string",
      },
      {
        data: "categoryName",
        className: "text-right",
        title: "Category Name",
        type: "string",
      },
      {
        data: "action",
        className: "text-right",
        title: "Action",
        type: "string",
      },
    ],
    columnDefs : categoryDef()
  });
}
let generateCategoryTable = (categories) => {
    
  categoryTable.clear().rows.add(categories).draw();
};

const getAllCategoryData = () => {
  let categories = [];
  showSpinner();
  httpGet(`${categoryApi}/all`)
    .done((resp) => {
      let data = resp.data;
      if (data && data.length > 0) {
        data.forEach((x) => categories.push(new CategoryModel(x)));
      }
      generateCategoryTable(categories);
      hideSpinner();
    })
    .fail(() => {
      generateCategoryTable([]);
      hideSpinner();
    });
};
const addCategory = () => {
  $("#category-add-btn").click(function (e) {
    e.preventDefault();
    showSpinner();
    let body = buildForm(addCategoryForm);
    body.id = null;
    let category = new CategoryModel(body);
    category.validateAndSave(category);
    hideSpinner();
  });
};

const categoryDef = () => {
  return [{
    targets:2,
    render: (data) => {
      let editBtn = ``;
      let deleteBtn = ``;
      return `<div class="w-100 justify-content-center">${editBtn}${deleteBtn}</div>`
    }
  }];
};

class CategoryModel {
  id;
  categoryName;
  action;
  constructor({id,categoryName}){
    this.id = id;
    this.categoryName = categoryName;
    this.action = {id,categoryName}
  }
  getId(){
    return this.id;
  }
  getCategoryName(){
    return this.categoryName;
  }
  setCategoryName(categoryName){
    this.categoryName = categoryName;
  }

  validateField = () => {
    let isValid = true;
    if (!this.categoryName) {
      warning("Missing field", "Category name can not be empty");
      isValid = false;
    }
    return isValid;
  };

  validateAndSave = () => {
    if (this.validateField()) {
      confirmBox(
        "Add Category !",
        "Do you want to add Category",
        this.saveCategory,
        this
      );
    }
  };

  saveCategory = () => {
    if (this) {
      httpPost(this, saveCategoryApi).then((resp) => {
        if (resp) {
          successThenDo(resp.status, resp.message, getAllCategoryData);
          clearForm(addCategoryForm);
        }
      });
    }
  };
}