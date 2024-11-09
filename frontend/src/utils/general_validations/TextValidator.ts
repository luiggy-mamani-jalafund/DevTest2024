export function isNullOrEmpty(input: string | null | undefined): boolean {
    return input === null || input === undefined || input.trim().length > 0;
}
