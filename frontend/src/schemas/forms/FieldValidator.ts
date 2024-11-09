export interface ValidationResult {
    isValid: boolean;
    message: null | string;
}

export type Validator<T> = (data: T) => ValidationResult;
