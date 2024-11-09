export interface CreatePollOptionDto {
    name: string;
}

export interface CreatePollDto {
    name: string;
    options: string[];
}

export interface VotePollOptionDto {
    optionId: string;
    voterEmail: string;
}
