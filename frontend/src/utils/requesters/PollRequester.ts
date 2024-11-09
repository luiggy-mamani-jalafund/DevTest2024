import { CreatePollDto } from "@/models/dtos/CreatePollDto";

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
