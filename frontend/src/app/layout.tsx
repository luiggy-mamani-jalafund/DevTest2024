import BaseLayout from "@/layouts/BaseLayout";

export default function RootLayout({
    children,
}: Readonly<{
    children: React.ReactNode;
}>) {
    return <BaseLayout>{children}</BaseLayout>;
}
