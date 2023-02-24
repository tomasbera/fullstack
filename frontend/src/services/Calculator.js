import axios from "axios";
import log from "@/components/Log.vue";
export function postCalculation(equation) {
    console.log(equation)
    return axios.post("http://localhost:8080/calculate/solve",equation)
        .then((response) => {
            console.log(response.data)
            return response.data;
        })
}

export function getAnswer() {
    return axios.get("http://localhost:8080/calculate/ans")
        .then((response) => {
            return response.data;
        })
}

export function getLog(){

}
