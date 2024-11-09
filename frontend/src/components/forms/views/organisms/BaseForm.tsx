import SmallLoader from "@/components/loaders/SmallLoader";
import { FormEvent } from "react";

interface Props {
    behavior: {
        onSubmit: () => Promise<void>;
        onCancel: () => void;
        isLoading: boolean;
        setLoading: (b: boolean) => void;
        isValid: boolean;
    };
    content: {
        message: string | null;
        setMessage: (s: string) => void;
        buttonName: string;
    };

    children: React.ReactNode;
}

const BaseForm: React.FC<Props> = ({ behavior, content, children }) => {
    const handleSubmit = async (e: FormEvent<HTMLFormElement>) => {
        e.preventDefault();

        if (behavior.isLoading) {
            return;
        }

        try {
            behavior.setLoading(true);
            await behavior.onSubmit();
        } catch (e: any) {
            content.setMessage(e.message);
        } finally {
            behavior.setLoading(false);
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            {children}
            <button type="button">cancel</button>
            <button disabled={behavior.isValid}>
                {behavior.isLoading ? <SmallLoader /> : content.buttonName}
            </button>
            {content.message && <small>{content.message}</small>}
        </form>
    );
};

export default BaseForm;
