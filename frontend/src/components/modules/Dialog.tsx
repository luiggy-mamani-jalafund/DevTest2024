interface Props {
    isOpen: boolean;
    close: () => void;
    children: React.ReactNode;
}

const Dialog: React.FC<Props> = ({ close, isOpen, children }) => {
    return isOpen && <div>{children}</div>;
};

export default Dialog;
