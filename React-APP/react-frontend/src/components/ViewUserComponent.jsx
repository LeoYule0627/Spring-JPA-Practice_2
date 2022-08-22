import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import UserService from '../services/UserService';

const ViewUserComponent = () => {
    const [user, setuser] = useState([])
    const { id } = useParams();

    useEffect(() => {
        UserService.getUserById(id).then((res) => {
            setuser(res.data);
            console.log(res.data);
        }).catch(error => {
            console.log(error);
        });
    }, [])

    return (
        <div>
            <br></br>
                <h3 className="text-center"> View User</h3>
                <table className="table table-striped table-bordered">
                    <thead>
                        <tr className='text-center'>
                            <th>User ID</th>
                            <th>User Name</th>
                            <th>User Age</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr className='text-center'>
                            <td>{user.id}</td>
                            <td>{user.name}</td>
                            <td>{user.age}</td>
                        </tr>
                    </tbody>
                </table>
        </div>
    );
}

export default ViewUserComponent;