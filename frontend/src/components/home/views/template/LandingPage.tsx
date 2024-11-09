"use client";

interface Props {
    appName: string;
}

const LandingPage: React.FC<Props> = ({ appName }) => {
    return (
        <main>
            <article>
                <h1>{appName}</h1>
            </article>
        </main>
    );
};

export default LandingPage;
