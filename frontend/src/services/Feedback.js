import axios from "axios";

export const postFeedback = () => {
    return axios.post("http://localhost:8080/feedback/", {})
        .then(() => {
            return true;
        })
        .catch(() => {
            return false;
        });
};