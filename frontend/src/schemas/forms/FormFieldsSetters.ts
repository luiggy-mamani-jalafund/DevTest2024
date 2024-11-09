import { OptionField, TextField } from "./FormFields";

type FieldSetter<T> = (data: T) => void;

export type TextFieldSetter = FieldSetter<TextField>;

export type OptionFieldSetter<T> = FieldSetter<OptionField<T>>;
