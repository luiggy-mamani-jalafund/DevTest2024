import { TextField } from "@/schemas/forms/FormFields";
import { isNullOrEmpty } from "./TextValidator";

export function validateTextField(field: TextField): boolean {
    return !field.errorMessage && !isNullOrEmpty(field.value);
}
