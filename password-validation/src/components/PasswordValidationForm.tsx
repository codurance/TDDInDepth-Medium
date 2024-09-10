import React, {useState} from "react";

type PasswordValidationFormProps = {
    onValidate: (password: string) => boolean;
}

export const PasswordValidationForm: React.FC<PasswordValidationFormProps> = ({onValidate}) => {
    const [password, setPassword] = useState("");

    const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        setPassword(event.target.value);
    }

    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        onValidate(password);
    };

    return (
        <form onSubmit={handleSubmit}>
            <label htmlFor="password">What's the password you want to validate?</label>
            <input type="password" id="password" name="password" onChange={handleChange}/>
            <button type="submit">
                Validate
            </button>
        </form>
    )
};