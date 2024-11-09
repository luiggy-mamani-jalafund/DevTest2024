export interface FormState {
    isValid: boolean;
    isLoading: boolean;
    message: string | null
}

export const DEFAULT_FORM_STATE: FormState =  {
    isLoading: false,
    isValid: false,
    message: null
}