import axios from "axios";

export const fetchCountryList = () => axios
    .get("http://localhost:8081/api/countries/").then(response => response.data);