import { CreatePollDto } from "@/models/dtos/CreatePollDto";
import { FetchedPoll } from "@/models/dtos/FetchedPollDto";

export async function gellAllPolls(): Promise<FetchedPoll[]> {
    const rest = await fetch("http://localhost:8080/api/v1/polls");
    const polls = await rest.json();

    return polls;
}

export async function createPoll(poll: CreatePollDto) {
    return await fetch("http://localhost:8080/api/v1/polls", {
        method: "POST",
        headers: {
            Accept: "application/json",
            "Content-Type": "application/json",
        },
        body: JSON.stringify(poll),
    });
}
