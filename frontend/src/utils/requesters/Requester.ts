export async function postFetch(data: any) {
    return await fetch("http://localhost:8080/api/", {
        method: "PUT",
        headers: {
            Accept: "application/json",
            "Content-Type": "application/json",
        },
        body: JSON.stringify(data),
    });
}
