"use client";

import Dialog from "@/components/modules/Dialog";
import { useState } from "react";
import CreatePollForm from "../organisms/CreatePollForm";

const PollRenderer = ({ name }: { name: string }) => {
    const [isCreating, setCreating] = useState(false);

    return (
        <article>
            <div>
                <h1>{name}</h1>
                <button onClick={() => setCreating(true)} disabled={isCreating}>
                    add new
                </button>
            </div>
            <Dialog isOpen={isCreating} close={() => setCreating(false)}>
                <CreatePollForm cancel={() => setCreating(false)} />
            </Dialog>
        </article>
    );
};

export default PollRenderer;
