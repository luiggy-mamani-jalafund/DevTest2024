export interface FetchedPollOption {
    id: string;
    name: string;
    votes: number;
}

export interface FetchedPoll {
    id: string;
    name: string;
    options: FetchedPollOption[];
}
