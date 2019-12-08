import axios from "axios";

export const submitCustomer = (customerName, inventor) => axios
    .put("http://localhost:8081/api/customers/" +
    customerName + "/inventors/" + inventor);
