import React, {useState} from "react";

type PasswordValidationFormProps = {
    onValidate: (password: string) => boolean;
}

export const PasswordValidationForm: React.FC<PasswordValidationFormProps> = ({onValidate}) => {
    const [password, setPassword] = useState("");
    const [error, setError] = useState("")

    const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        setPassword(event.target.value);
    }

    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        const isValid = onValidate(password);

        if (!isValid) {
            setError("Invalid");
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <label htmlFor="password">What's the password you want to validate?</label>
            <input type="password" id="password" name="password" onChange={handleChange}/>
            <span>{error}</span>
            <button type="submit">
                Validate
            </button>
        </form>
    )
};