"use client";

import Dialog from "@/components/modules/Dialog";
import { useEffect, useState } from "react";
import CreatePollForm from "../organisms/CreatePollForm";
import { FetchedPoll } from "@/models/dtos/FetchedPollDto";
import PageLoader from "@/components/loaders/PageLoader";
import { gellAllPolls } from "@/utils/requesters/PollRequester";

const PollRenderer = ({ name }: { name: string }) => {
    const [isCreating, setCreating] = useState(false);
    const [polls, setPolls] = useState<null | FetchedPoll[]>(null);

    useEffect(() => {
        gellAllPolls()
            .then((res) => setPolls(res))
            .catch(() => {
                setPolls([]);
            });
    }, []);

    if (!polls) {
        return <PageLoader />;
    }

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

            <article>
                {polls.map((poll, i) => (
                    <section key={`poll-${i}`}>
                        <h2>{poll.name}</h2>

                        {poll.options.map((option, i) => (
                            <div key={`poll-option-${i}`}>
                                <h4>
                                    {option.name} - <i>{option.votes} votes</i>
                                </h4>
                            </div>
                        ))}
                    </section>
                ))}
            </article>
        </article>
    );
};

export default PollRenderer;
