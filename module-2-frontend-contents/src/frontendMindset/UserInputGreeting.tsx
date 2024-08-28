import React, {useState} from 'react';

const UserInputGreeting: React.FC = () => {
    const [name, setName] = useState<string>()

    const handleNameChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        setName(event.target.value);
    };

    return (
        <>
            <label htmlFor="name">What's your name?</label>
            <input onChange={handleNameChange} id="name" type="text"/>
            <p>Hello, {name}!</p>
        </>
    );
};

export default UserInputGreeting;