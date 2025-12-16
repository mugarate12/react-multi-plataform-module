import { useFocusable } from "@noriginmedia/norigin-spatial-navigation";
import type { ButtonHTMLAttributes } from "react";

type Props = {} & ButtonHTMLAttributes<HTMLButtonElement>;

export default function Button({ onClick, ...rest }: Props) {
	const { ref } = useFocusable({
		onEnterPress: onClick,
	});

	return <button ref={ref} onClick={onClick} {...rest}></button>;
}
