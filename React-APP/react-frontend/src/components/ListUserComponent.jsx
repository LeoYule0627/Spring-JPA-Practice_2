import React, { useState, useEffect } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import UserService from '../services/UserService';

const ListUserComponent = () => {
    const [users, setusers] = useState([])
    const [searchId, setSearchId] = useState()

    const history = useNavigate();

    useEffect(() => {
        getAllUsers();
    }, [])

    const getAllUsers = () => {
        UserService.getAllUsers().then((res) => {
            setusers(res.data)
            console.log(res.data);
        }).catch(error => {
            console.log(error);
        })
    }

    const deleteUser = (userId) => {
        var answer = window.confirm("Delete data?");
        if (answer) {
            UserService.deleteUser(userId).then((res) => {
                getAllUsers();
            })
        }
    }

    const viewUser = (searchId) => {
        if (searchId === undefined) (
            alert("NULL")
        )
        else {
            console.log(searchId)
            history(`/view/${searchId}`)
        }
    }

    return (
        <div>
            <h2 className="text-center">UserList</h2>
            <Link to="/create" className="btn btn-primary mb-2 "> Add User</Link>
            <button className="btn btn-outline-secondary" onClick={() => viewUser(searchId)}
                style={{ float: 'right' }}> Search</button>
            <input
                type="number"
                placeholder='Search Id'
                className="form-control"
                onChange={(e) => setSearchId(e.target.value)}
                style={{ width: "125px", float: 'right' }}
            ></input>

            <div className="row">
                <table className="table table-striped table-bordered">
                    <thead>
                        <tr className="text-center">
                            <th>User Id</th>
                            <th>User Name</th>
                            <th>User Age</th>
                            <th>Actions</th>
                        </tr>
                    </thead>

                    <tbody>
                        {
                            users.map(
                                user =>
                                    <tr key={user.id} className="text-center">
                                        <td>{user.id}</td>
                                        <td>{user.name}</td>
                                        <td>{user.age}</td>
                                        <td>
                                            <Link className="btn btn-outline-info" to={`/update/${user.id}`} >Update</Link>
                                            <button className="btn btn-outline-secondary" onClick={() => deleteUser(user.id)}
                                                style={{ marginLeft: "10px" }}> Delete</button>
                                        </td>
                                    </tr>
                            )
                        }
                    </tbody>

                </table>
            </div>

        </div>
    )
}

export default ListUserComponent;