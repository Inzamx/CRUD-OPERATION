import './UpdateUser.css';
import { useEffect, useState } from 'react';
import { Button, Form } from 'react-bootstrap';
import { useNavigate, useParams } from 'react-router-dom';

const UpdateUser = () => {
    const { id } = useParams();
    const navigate = useNavigate();
    const [formData, setFormData] = useState({
        name: "",
        email: "",
        phone: "",
        department: "",
    });

    const handleInputChange = (event) => {
        const { name, value } = event.target;
        setFormData({ ...formData, [name]: value });
    };

    useEffect(() => {
        const fetchEmployee = async () => {
            try {
                const response = await fetch(`http://localhost:8080/api/employee/${id}`);
                if (!response.ok) throw new Error("Employee not found");

                const data = await response.json();
                setFormData(data);
            } catch (error) {
                console.error("Error fetching employee:", error.message);
            }
        };
        fetchEmployee();
    }, [id]);

    const handleSubmit = async (event) => {
        event.preventDefault();
        console.log("Submitting Data:", JSON.stringify(formData));

        try {
            const response = await fetch(`http://localhost:8080/api/employee/${id}`, {
                method: "PATCH", // Ensure PATCH matches @PatchMapping API
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(formData),
            });

            console.log("Response Status:", response.status);

            if (!response.ok) {
                const errorMessage = await response.text();
                throw new Error(`Failed to update employee: ${errorMessage}`);
            }

            const updatedEmployee = await response.json();
            console.log("employee updated:", updatedEmployee);

            alert("Employee updated successfully!");
            navigate("/");
        } catch (error) {
            console.error("Error updating employee:", error.message);
        }
    };

    return (
        <div className="center-form">
            <h1>Edit Employee</h1>
            <Form onSubmit={handleSubmit}>
                <Form.Group controlId="formBasicName">
                    <Form.Control
                        type="text"
                        name="name"
                        placeholder="Enter name"
                        value={formData.name}
                        onChange={handleInputChange}
                    />
                </Form.Group>

                <Form.Group controlId="formBasicEmail">
                    <Form.Control
                        type="email"
                        name="email"
                        placeholder="Enter email"
                        value={formData.email}
                        onChange={handleInputChange}
                    />
                </Form.Group>

                <Form.Group controlId="formBasicPhone">
                    <Form.Control
                        type="text"
                        name="phone"
                        placeholder="Enter phone"
                        value={formData.phone}
                        onChange={handleInputChange}
                    />
                </Form.Group>

                <Form.Group controlId="formBasicDepartment">
                    <Form.Control
                        type="text"
                        name="department"
                        placeholder="Enter department"
                        value={formData.department}
                        onChange={handleInputChange}
                    />
                </Form.Group>

                <Button variant="primary" type="submit" className="w-100">
                    Edit Employee
                </Button>
            </Form>
        </div>
    );
};

export default UpdateUser;