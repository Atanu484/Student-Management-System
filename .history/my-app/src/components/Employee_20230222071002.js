import React from 'react';
im
import { useNavigate } from "react-router-dom";

const Student = ({ Student, deleteStudent }) => {
    
    const navigate = useNavigate();
    
    // Method that edits the Student data and navigates the page to path="/editStudent/:id"
    const editStudent = (e, id) => {
        e.preventDefault();
        navigate(`/editStudent/${id}`);
    };

    return (
        <tr key={Student.id}>
            <td>
                <div>{Student.firstName}</div>
            </td>
            <td>
                <div>{Student.lastName}</div>
            </td>
            <td>
                <div>{Student.emailId}</div>
            </td>
            <td className='text-right px-6 py-4'>
                <a
                    onClick={(e, id) => editStudent(e, Student.id)} //Executes the editStudent method upon clicking
                    className='text-left text-indigo-500 hover:text-indigo-800 px-6 hover: cursor-pointer'>
                    Edit
                </a>
                <a
                    onClick={(e, id) => deleteStudent(e, Student.id)} //Executes the deleteStudent method upon clicking
                    className='text-left text-indigo-500 hover:text-indigo-800 px-4 hover: cursor-pointer'>
                    Delete
                </a>
            </td>
        </tr>
    );
};

export default Student;