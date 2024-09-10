import React from "react";

type PasswordValidationFormProps = {
    onValidate: (password: string) => boolean;
}

export const PasswordValidationForm: React.FC<PasswordValidationFormProps> = ({onValidate}) => {

    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();

        onValidate("Password123_");
    };

    return (
        <form onSubmit={handleSubmit}>
            <label htmlFor="password">What's the password you want to validate?</label>
            <input type="password" id="password" name="password"/>
            <button type="submit">
                Validate
            </button>
        </form>
    )
};