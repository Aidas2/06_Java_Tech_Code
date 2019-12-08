import axios from "axios";

// export const submitHoliday = (holidayId, country) => axios
//     .put("http://localhost:8081/api/holidays/" +
//         holidayId + "/countries/" + country);

export const submitHoliday = (holidayTitle, country) => axios
    .put("http://localhost:8081/api/holidays/" +
        holidayTitle + "/countries/" + country);
