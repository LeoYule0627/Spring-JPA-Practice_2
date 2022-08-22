import axios from 'axios';

const USER_API_BASE_URL = "http://localhost:8080/api/v1/users";

class UserService {

    getAllUsers() {
        return axios.get(USER_API_BASE_URL);
    }

    getUserById(userId) {
        return axios.get(USER_API_BASE_URL + "/" + userId);
    }

    createUser(user) {
        return axios.post(USER_API_BASE_URL , user);
    }

    updateUser(userId, user) {
        return axios.put(USER_API_BASE_URL + "/" + userId, user);
    }
    deleteUser(userId) {
        return axios.delete(USER_API_BASE_URL + "/" + userId);
    }
}

export default new UserService()