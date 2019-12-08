import axios from "axios";

export const fetchInventorList = () => axios
    .get("http://localhost:8081/api/inventors/").then(response => response.data);