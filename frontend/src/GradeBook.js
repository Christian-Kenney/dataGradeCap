import React, { useState, useEffect } from 'react';
import './GradeBook.css'; // Import the CSS file

const GradeBook = () => {
    // Sample user name, replace with your authentication logic
    const [user, setUser] = useState('John Doe');
    const [users, setUsers] = useState();
    // Sample class list, replace with your data source
    const [classes, setClass] = useState([]);
    const [selectedClass, setSelectedClass] = useState('');
    const [students, setStudents] = useState([]);
    const [assignments, setAssignments] = useState([]);
    // Sample grade data, replace with your data source
    const [grades, setGrades] = useState({});
    const userId = '1';

    const handleLogout = () => {
        // Implement logout logic here
        alert('Logout button clicked');
    };

    const handleClassChange = (event) => {
        setSelectedClass(event.target.value);
    };

    const handleAddStudent = () => {
        const newStudent = `Student ${students.length + 1}`;
        setStudents([...students, newStudent]);
        updateGradesForNewStudent(newStudent);
    };

    const handleAddAssignment = () => {
        const newAssignment = `Assignment ${assignments.length + 1}`;
        setAssignments([...assignments, newAssignment]);
        updateGradesForNewAssignment(newAssignment);
    };

    const updateGradesForNewStudent = (newStudent) => {
        const updatedGrades = { ...grades };
        updatedGrades[newStudent] = {};
        setGrades(updatedGrades);
    };

    const updateGradesForNewAssignment = (newAssignment) => {
        const updatedGrades = { ...grades };
        Object.keys(updatedGrades).forEach((student) => {
            updatedGrades[student][newAssignment] = '';
        });
        setGrades(updatedGrades);
    };

    const handleGradeChange = (student, assignment, event) => {
        const updatedGrades = { ...grades };
        updatedGrades[student] = {
            ...updatedGrades[student],
            [assignment]: event.target.value,
        };
        setGrades(updatedGrades);
    };


    const fetchUserById = async (userId) => {
        try {
            const response = await fetch(`http://localhost:8080/users/${userId}`);
            if (!response.ok) {
                throw new Error('Failed to fetch userrrr');
            }
            const userData = await response.json();
            setUser(userData);
        } catch (error) {
            console.error('Error fetching user:', error);
        }
    };

    const fetchUsers = async () => {
        try {
            const response = await fetch(`http://localhost:8080/users`);
            if (!response.ok) {
                throw new Error('Failed to fetch user');
            }
            const usersData = await response.json();
            setUsers(usersData);
        } catch (error) {
            console.error('Error fetching user:', error);
        }
    };

    const fetchClassByUserId = async () => {
        try {
            const response = await fetch(`http://localhost:8080/class`);
            if (!response.ok) {
                throw new Error('Failed to fetch user');
            }
            const classData = await response.json();
            setClass(classData);
        } catch (error) {
            console.error('Error fetching user:', error);
        }
    };

    const fetchAssignments = async () => {
        try {
            const response = await fetch(`http://localhost:8080/assignment`);
            if (!response.ok) {
                throw new Error('Failed to fetch user');
            }
            const assignmentData = await response.json();
            console.log("HERERE: ", assignmentData)
            setAssignments(assignmentData);
        } catch (error) {
            console.error('Error fetching user:', error);
        }
    };

    const fetchStudents = async () => {
        try {
            const response = await fetch(`http://localhost:8080/student`);
            if (!response.ok) {
                throw new Error('Failed to fetch user');
            }
            const studentData = await response.json();
            console.log("HERERE: ", studentData)
            setStudents(studentData);
        } catch (error) {
            console.error('Error fetching user:', error);
        }
    };

    const fetchGrades = async () => {
        try {
            const response = await fetch(`http://localhost:8080/grade`);
            if (!response.ok) {
                throw new Error('Failed to fetch user');
            }
            const gradeData = await response.json();
            console.log("HERERE: ", gradeData)
            setGrades(gradeData);
        } catch (error) {
            console.error('Error fetching user:', error);
        }
    };

    const handleLogUserData = () => {
        fetchUserById(1);
        fetchClassByUserId()
        fetchAssignments()
        fetchStudents()
        fetchUsers()
        fetchGrades()
    };

    const handleAssignmentNameChange = (index, newName) => {
        // Create a copy of the current assignments array
        const updatedAssignments = [...assignments];
        // Update the assignment name at the specified index
        updatedAssignments[index] = newName;
        // Set the updated assignments array as the new state
        setAssignments(updatedAssignments);
    };
    useEffect(() => {
        // This effect runs whenever the user state changes
        if(users){
            console.log('users data: ', users)
        }
        if (user) {
            console.log('User data:', user); // Log user data when it's available
        }
        if(classes) {
            console.log('class data: ', classes)
        }
        if(assignments){
            console.log('assignment data: ', assignments)
        }
        if(students){
            console.log('student data: ', students)
        }
        if(grades){
            console.log('grade data: ', grades)
        }

    }, [user]);

    return (
        <div className="gradebook">
            <header className="header">
                <h1 className="title">GradeBook</h1>
                <div className="user-info">
                    <span className="username">Welcome, {user.name}</span>
                    <button className="logout-btn" onClick={handleLogout}>Logout</button>
                </div>
                <div className="class-dropdown">
                    <select value={selectedClass} onChange={handleClassChange}>
                        <option value="">Select a class</option>
                        {classes.map((classItem, index) => (
                            <option key={index} value={classItem.subject}>{classItem.subject}</option>
                        ))}
                    </select>
                    <button onClick={handleLogUserData}>Log User Data</button>
                </div>
            </header>
            <main className="main">
                <div className="controls">
                    <button onClick={handleAddStudent}>Add Student</button>
                    <button onClick={handleAddAssignment}>Add Assignment</button>
                </div>
                {/* Render grading components below */}
                {/* For simplicity, rendering sample grades data */}
                <div className="grades">
                    <h2>Grades for {selectedClass}</h2>
                    {/* Sample grading table */}
                    <table>
                        <thead>
                        <tr>
                            <th>Student</th>
                            {assignments.map((assignmentItem, index) => (
                                <th key={index}>
                                    <input
                                        type="text"
                                        value={assignmentItem.name}
                                        onChange={(event) => handleAssignmentNameChange(index, event.target.value)}
                                    />
                                </th>
                            ))}
                        </tr>
                        </thead>
                        <tbody>
                        {/* Sample data, replace with actual data */}
                        {students.map((studentItem, index) => (
                            <tr key={index}>
                                <td>{users[studentItem.userId].name}</td>
                                {assignments.map((assignment, assignmentIndex) => (
                                    <td key={assignmentIndex}>
                                        <input
                                            type="text"
                                            value={'' || ''}vcf
                                            onChange={(event) =>
                                                handleGradeChange(studentItem, assignment, event)
                                            }
                                        />
                                    </td>
                                ))}
                            </tr>
                        ))}
                        </tbody>
                    </table>
                </div>
            </main>
        </div>

    );
};

export default GradeBook;
