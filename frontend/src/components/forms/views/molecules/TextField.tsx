import { Validator } from "@/schemas/forms/FieldValidator";
import { TextField as FormTextField } from "@/schemas/forms/FormFields";
import { TextFieldSetter } from "@/schemas/forms/FormFieldsSetters";
import { ChangeEvent } from "react";

interface Props {
    legend: string;
    values: FormTextField;
    setter: TextFieldSetter;
    validator: Validator<string>;
}

const TextField: React.FC<Props> = ({ legend, setter, values, validator }) => {
    const handleChange = (e: ChangeEvent<HTMLInputElement>) => {
        let value = e.target.value;
        const { isValid, message } = validator(value);

        setter({
            value: value,
            errorMessage: isValid ? null : message,
        });
    };

    return (
        <fieldset>
            <legend>{legend}</legend>
            <input type="text" onChange={handleChange} value={values.value} />
            {values.errorMessage && <small>{values.errorMessage}</small>}
        </fieldset>
    );
};

export default TextField;
