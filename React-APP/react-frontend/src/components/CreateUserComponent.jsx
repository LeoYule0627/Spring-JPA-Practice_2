import React, { useState, useEffect } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
import UserService from '../services/UserService';

const CreateUserComponent = () => {
  const [user, setUser] = useState({
    id: "",
    name: "",
    age: "",
  });

  const history = useNavigate();
  const { urlId } = useParams();

  useEffect(() => {
    const fetchData = async () => {
      try {
        UserService.getUserById(urlId).then((res) => {
          setUser(res.data);
        });
      } catch (error) {
        console.log(error);
      }
    }
    fetchData();
  }, [urlId]);

  const handleChange = (e) => {
    const value = e.target.value;
    setUser({ ...user, [e.target.name]: value });
  }

  const saveUser = (e) => {
    e.preventDefault();

    console.log(JSON.stringify(user));
    if (urlId) {
      UserService.updateUser(urlId, user).then((res) => {
        alert(res.data.state);
        history('/users')
      }).catch(error => {
        console.log(error);
      })
    } else {
      UserService.createUser(user).then((res) => {
        alert(res.data.state);
        history('/users')
        console.log(res.data);
      }).catch(error => {
        console.log(error);
      })
    }
  }

  const title = () => {
    if (urlId) {
      return <h2 className='text-center'>Update User</h2>
    } else {
      return <h2 className='text-center'>Add User</h2>
    }
  }

  const idDisable = () => {
    if (urlId) {
      return <input
        name="id"
        className="form-control"
        value={user.id}
        disabled
        onChange={(e) => handleChange(e)}
      ></input>
    } else {
      return <input
        name="id"
        type="number"
        className="form-control"
        value={user.id}
        onChange={(e) => handleChange(e)}
      ></input>
    }
  }

  return (
    <div>
      <br></br>
      <div className="container">
        <div className="row">
          <div className="card col-md-6 offset-md-3 offset-md-3">
            {
              title()
            }
            <div className="card-body">
              <form>
                
                <div className="form-group mb-2">
                  <label className="form-label"> ID: </label>
                  {
                    idDisable()
                  }
                </div>
                <div className="form-group mb-2">
                  <label className="form-label"> Name: </label>
                  <input
                    type="text"
                    name="name"
                    className="form-control"
                    value={user.name}
                    onChange={(e) => handleChange(e)}
                  ></input>
                </div>
                <div className="form-group mb-2">
                  <label className="form-label"> Age: </label>
                  <input
                    type="number"
                    name="age"
                    className="form-control"
                    value={user.age}
                    onChange={(e) => handleChange(e)}
                  ></input>
                </div>
                <div>
                  <button className="btn btn-outline-success" onClick={saveUser} style={{ marginRight: "10px" }}>Save</button>
                  <Link to='/users' className='btn btn-outline-secondary'>Cancel</Link>
                </div>
              </form>
              
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default CreateUserComponent;