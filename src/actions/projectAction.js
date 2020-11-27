import axios from "axios"
import {GET_ERRORS, GET_PROJECTS} from "./types";

export const createProject = (project, history) => async dispatch => {
    try {
        const res = await axios.post("http://localhost:8080/api/project/create", project)
        history.push("/dashboard");
/*        dispatch({
            type: GET_ERRORS,
            payload: {}
        });*/
    } catch (err) {
        console.log(err);
        dispatch({
            type: GET_ERRORS,
            payload: err.response.data
        });
    }
}

export const getProjects = () => async dispatch =>{
    const res = await axios.get('http://localhost:8080/api/project/all')
    console.log(res);
    dispatch({
        type:GET_PROJECTS,
        payload: res.data
    });
};
