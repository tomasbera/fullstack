import axios from "axios";
export const postCalculation = async (expression)=> {
    return await axios
        .post("http://localhost:8080/calculate", {
            expression
        })
        .then((response) => {
            return response.data;
        })
        .catch((error) => {
            if (error.response) {
                console.log(error.response.data);
                console.log(error.response.status);
                console.log(error.response.headers);
            } else if (error.request) {
                console.log(error.request);
            } else {
                console.log('Error', error.message);
            }
            return error.data

        });
};