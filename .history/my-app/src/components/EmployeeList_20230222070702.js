
import React, {useState, useEffect} from 'react';
import { useNavigate } from "react-router-dom";
import StudentService from '../../services/StudentService';
import Student from "./Student";

const StudentList = () => {

    //Using useNavigate hook to navigate to the Student details page
    const navigate = useNavigate();

    const [loading, setLoading] = useState(true);
    const [Students, setStudents] = useState();

    // This methods gets the Students data from the API
    useEffect(() => {
        const fetchData = async () => {
            setLoading(true);
            try {
               const response = await StudentService.getStudents(); // await for the response may take some time
               setStudents(response.data);
            } catch (error) {
                console.log(error);
            }
            setLoading(false); // The loading state is set to false once the data is fetched
        }
      fetchData();
    }, [])

    // Method filters and deletes the data based on id
    const deleteStudent = (e, id) => {
        e.preventDefault();
        StudentService.deleteStudent(id)
        .then((res) => {
            if(Students) {
                setStudents((previousElement) => {
                    return previousElement.filter((Student) => Student.id !== id);
                })
            }
        })
    }

    return (
        <div className="container mx-auto my-8">
            <div className="h-12">
                <button
                onClick={() => navigate('/addStudent')}
                type="button" className="text-white bg-gray-800 hover:bg-gray-900 focus:outline-none focus:ring-4 focus:ring-gray-300 font-medium rounded-full text-sm px-5 py-2.5 mr-2 mb-2 dark:bg-gray-800 dark:hover:bg-gray-700 dark:focus:ring-gray-700 dark:border-gray-700">Add Student</button>
            </div>
            <div className="flex shadow border-b">
                <table className="min-w-full">
                    <thead className="bg-gray-50">
                        <tr>
                            <th className='text-left'>First Name</th>
                            <th className='text-left'>Last Name</th>
                            <th className='text-left'>Email Id</th>
                            <th className='text-right px-24'>Actions</th>
                        </tr>
                    </thead>
                    {!loading && (
                    <tbody className='bg-white'>
                        {Students.map((Student) => (
                        <Student Student={Student} 
                        deleteStudent={deleteStudent}
                        key={Student.id}></Student>
                        ))};
                        </tbody>
                        )}
                </table>
            </div>
        </div>
    );
};

export default StudentList;