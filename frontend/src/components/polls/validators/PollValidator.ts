import { ValidationResult } from "@/schemas/forms/FieldValidator";
import { isNullOrEmpty } from "@/utils/general_validations/TextValidator";

export function validatePollName(name: string): ValidationResult {
    if (!isNullOrEmpty(name)) {
        return {
            isValid: false,
            message: "the name should not be empty",
        };
    } else {
        return {
            isValid: true,
            message: null,
        };
    }
}

export function validatePollOption(
    option: string,
    options: string[],
): ValidationResult {
    if (!isNullOrEmpty(option)) {
        return {
            isValid: false,
            message: "the option should not be empty",
        };
    } else if (
        options
            .map((op) => op.toLocaleLowerCase())
            .includes(option.toLocaleLowerCase())
    ) {
        return {
            isValid: false,
            message: "the option should not be repeated",
        };
    } else {
        return {
            isValid: true,
            message: null,
        };
    }
}

export function validateAmountOfPolls(options: any[]): boolean {
    return options.length > 1;
}
