
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import './App.css';
import AddStudent from './components/AddStudent';
import StudentList from './components/StudentList';
import NavBar from './components/NavBar';
import UpdateStudent from "./components/UpdateStudent";

function App() {
  return (
    <>
      <BrowserRouter>
        <NavBar />
        <Routes>
          <Route path="/" element={<StudentList />}></Route>
          <Route path="/StudentList" element={<StudentList />}></Route>
          <Route path="/addStudent" element={<AddStudent />}></Route>
          <Route path="/editStudent/:id" element={<UpdateStudent />}>
          </Route>
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
