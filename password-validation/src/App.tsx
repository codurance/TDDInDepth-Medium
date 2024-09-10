import {PasswordValidationForm} from "./components/PasswordValidationForm.tsx";
import React, {useState} from "react";
import {PasswordValidation} from "./PasswordValidator/PasswordValidation.ts";
import {useValidator} from "./hooks/useValidator.ts";

const App = () => {
    const [validation, setValidation] = useState<PasswordValidation>()
    const {validator} = useValidator(validation);

    const handleSelection = (event: React.ChangeEvent<HTMLSelectElement>) => {
        setValidation(event.target.value as PasswordValidation);
    }
    return (
        <>
            <label htmlFor="strategy">
                What validation strategy do you want to use?
            </label>
            <select id="strategy" defaultValue={PasswordValidation.STANDARD_VALIDATION} onChange={handleSelection}>
                <option>{PasswordValidation.STANDARD_VALIDATION}</option>
                <option>{PasswordValidation.SHORT_VALIDATION}</option>
            </select>
            <PasswordValidationForm onValidate={validator}/>
        </>
    );
}

export default App
