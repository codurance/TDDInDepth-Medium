import React from 'react';

type GreetingProps = {
    name: string;
}

const Greeting: React.FC<GreetingProps> = ({name}) => {
    return (
        <p>Hello, {name}!</p>
    );
};

export default Greeting;