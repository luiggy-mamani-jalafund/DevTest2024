interface BaseField {
    errorMessage: null | string;
}

export interface TextField extends BaseField {
    value: string;
}

export interface OptionField<T> extends BaseField {
    option: T | null;
}


export const DEFAULT_TEXT_FIELD: TextField = {
    errorMessage: null,
    value: ""
}