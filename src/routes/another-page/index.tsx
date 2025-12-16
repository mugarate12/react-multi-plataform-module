import {
	FocusContext,
	useFocusable,
} from "@noriginmedia/norigin-spatial-navigation";
import { createFileRoute } from "@tanstack/react-router";
import { useEffect } from "react";
import Button from "@/components/Button";
import logo from "../../logo.svg";

export const Route = createFileRoute("/another-page/")({
	component: RouteComponent,
});

function RouteComponent() {
	const { ref, focusKey, focusSelf } = useFocusable();

	useEffect(() => {
		focusSelf();
	}, [focusSelf]);

	return (
		<div className="w-full h-dvh flex flex-col items-center justify-center bg-gray-950">
			<section className="flex flex-col items-center gap-4">
				<img
					src={logo}
					className="h-[20vmin] pointer-events-none animate-[spin_20s_linear_infinite]"
					alt="logo"
				/>
				<h1 className="text-white text-2xl md:text-6xl">
					Olá, sou outra página
				</h1>

				<FocusContext.Provider value={focusKey}>
					<div ref={ref} className="flex flex-col items-center gap-4">
						<Button
							type="button"
							className="btn btn-primary md:btn-xl data-[focused=true]:btn-secondary"
							onClick={() => history.back()}
						>
							voltar
						</Button>
					</div>
				</FocusContext.Provider>
			</section>
		</div>
	);
}
