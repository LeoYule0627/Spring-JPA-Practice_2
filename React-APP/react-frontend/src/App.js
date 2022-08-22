import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import './App.css';
import ListUserComponent from './components/ListUserComponent';
import HeaderComponent from './components/HeaderComponent';
import CreateUserComponent from './components/CreateUserComponent';
import ViewUserComponent from './components/ViewUserComponent';

function App() {
return (
  <div>
    <Router>
      <HeaderComponent />
      <div className="container">
        <Routes>
          <Route path="/" element={<ListUserComponent />}></Route>
          <Route path="/users" element={<ListUserComponent />}></Route>
          <Route path="/update/:urlId" element={<CreateUserComponent />}></Route>
          <Route path="/create" element={<CreateUserComponent />}></Route>
          <Route path="/view/:id" element={<ViewUserComponent />}></Route>
        </Routes>
      </div>
    </Router>
  </div>
);
}
export default App
