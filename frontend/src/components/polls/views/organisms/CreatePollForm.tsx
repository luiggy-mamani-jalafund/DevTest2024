"use client";

import TextField from "@/components/forms/views/molecules/TextField";
import BaseForm from "@/components/forms/views/organisms/BaseForm";
import { CreatePollDto } from "@/models/dtos/CreatePollDto";
import { DEFAULT_FORM_STATE, FormState } from "@/schemas/forms/Form";
import {
    DEFAULT_TEXT_FIELD,
    TextField as FormTextField,
} from "@/schemas/forms/FormFields";
import { useEffect, useState } from "react";
import {
    validateAmountOfPolls,
    validatePollName,
    validatePollOption,
} from "../../validators/PollValidator";
import { validateTextField } from "@/utils/general_validations/TextFieldValidator";
import { createPoll } from "@/utils/requesters/PollRequester";

interface Form {
    name: FormTextField;
    options: FormTextField[];
}

interface Props {
    cancel?: () => void;
}

const CreatePollForm: React.FC<Props> = ({ cancel }) => {
    const DEAFULT_FORM: Form = {
        name: DEFAULT_TEXT_FIELD,
        options: [],
    };
    const [form, setForm] = useState<Form>(DEAFULT_FORM);
    const [formState, setFormState] = useState<FormState>(DEFAULT_FORM_STATE);

    const onCancel = () => {
        if (!cancel) {
            setForm(DEAFULT_FORM);
        } else {
            cancel();
        }
    };

    const addOption = () => {
        setForm((prev) => ({
            ...prev,
            options: [...prev.options, DEFAULT_TEXT_FIELD],
        }));
    };

    const updateOption = (value: FormTextField, index: number) => {
        setForm((prev) => ({
            ...prev,
            options: prev.options.map((option, i) => {
                if (i === index) {
                    return value;
                } else {
                    return option;
                }
            }),
        }));
    };

    const onSubmit = async () => {
        let poll: CreatePollDto = {
            name: form.name.value,
            options: form.options.map((option) => {
                return option.value;
            }),
        };

        await createPoll(poll);
    };

    useEffect(() => {
        let isValidOptions = form.options.reduce(
            (acc, op) => acc && validateTextField(op),
            false,
        );
        setFormState((prev) => ({
            ...prev,
            isValid:
                validateTextField(form.name) &&
                validateAmountOfPolls(form.options) &&
                isValidOptions,
        }));
    }, [formState]);

    return (
        <BaseForm
            content={{
                buttonName: "Save",
                message: formState.message,
                setMessage: (m) =>
                    setFormState((prev) => ({ ...prev, message: m })),
            }}
            behavior={{
                isLoading: formState.isLoading,
                isValid: formState.isValid,
                onCancel: onCancel,
                onSubmit: onSubmit,
                setLoading: (l) =>
                    setFormState((prev) => ({ ...prev, isLoading: l })),
            }}
        >
            <TextField
                legend="name"
                setter={(n) => setForm((prev) => ({ ...prev, name: n }))}
                validator={validatePollName}
                values={form.name}
            />

            <div>
                <h2>Options</h2>
                {form.options.map((option, i) => (
                    <TextField
                        key={`option-${i}`}
                        legend={`${i + 1}`}
                        setter={(option) => updateOption(option, i)}
                        validator={(optionName) =>
                            validatePollOption(
                                optionName,
                                form.options.map((op) => op.value),
                            )
                        }
                        values={option}
                    />
                ))}
            </div>

            <button type="button" onClick={addOption}>
                Add option
            </button>
        </BaseForm>
    );
};

export default CreatePollForm;
