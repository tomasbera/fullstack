import axios from "axios";
export function postCalculation(equation) {
    console.log("hallo")
    return axios.post("http://localhost:8080/calculate/solve", equation)
        .then((response) => {
            console.log("hei")
            console.log(response.data)
            return response.data;
        })
}

export function getAnswer() {
    return axios.post("http://localhost:8080/calculate/ans")
        .then((response) => {
            return response.data;
        })
}

export function getLog() {
    return axios.post("http://localhost:8080/calculate/log")
        .then((response) => {
            return response.data;
        })
}