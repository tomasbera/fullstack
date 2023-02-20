import { mount } from "@vue/test-utils";
import { describe, test, expect } from "vitest";
import calculator from "@/components/Calculator.vue";

describe("Calculator", () => {
    test("Calculator render display with 0 successfully at mount", () => {
        const wrapper = mount(calculator);

        const displayText = wrapper.find('.a')
        expect(displayText.element.textContent).toBe('0')
    });

    test("Calculator render display with 1 successfully after click 1", async () => {
        const wrapper = mount(calculator);
        const button = wrapper.find('.f');
        await button.trigger("click");
        const displayText = wrapper
            .find('.a')
        expect(displayText.element.textContent).toBe("1");
    });

    test("Calculator sums 1 + 1 together", async () => {
        const wrapper = mount(calculator);
        const displayText = wrapper.find('.a')
        const button1 = wrapper.find('.f');
        const button_pls = wrapper.find(".e");
        const button_eqs = wrapper.find(".v");

        await button1.trigger("click");
        await button_pls.trigger("click")
        await button1.trigger("click");
        await button_eqs.trigger("click");
        expect(displayText.element.textContent).toBe("2");

    });

    test("Calculator addition of 2 * 2 = 4", async () => {
        const wrapper = mount(calculator);
        const displayText = wrapper.find('.a')
        const button2 = wrapper.find('.g');
        const button_mult = wrapper.find(".m");
        const button_eqs = wrapper.find(".v");

        await button2.trigger("click");
        await button_mult.trigger("click")
        await button2.trigger("click");
        await button_eqs.trigger("click");
        expect(displayText.element.textContent).toBe("4");

    });

    test("Calculator addition of 2 / 2 = 1", async () => {
        const wrapper = mount(calculator);
        const displayText = wrapper.find('.a')
        const button2 = wrapper.find('.g');
        const button_del = wrapper.find(".r");
        const button_eqs = wrapper.find(".v");

        await button2.trigger("click");
        await button_del.trigger("click")
        await button2.trigger("click");
        await button_eqs.trigger("click");
        expect(displayText.element.textContent).toBe("1");

    });

    test("Calculator addition of 2 - 2 = 0", async () => {
        const wrapper = mount(calculator);
        const displayText = wrapper.find('.a')
        const button2 = wrapper.find('.g');
        const button_mult = wrapper.find(".i");
        const button_eqs = wrapper.find(".v");

        await button2.trigger("click");
        await button_mult.trigger("click");
        await button2.trigger("click");
        await button_eqs.trigger("click");
        expect(displayText.element.textContent).toBe("0");
    });

    test("Check that Clear method setts to zero", async () => {
        const wrapper = mount(calculator);

        const clear = wrapper.find('.b');
        const button1 = wrapper.find('.f');
        const displayText = wrapper.find('.a');

        await button1.trigger("click");
        await clear.trigger("click");

        expect(displayText.element.textContent).toBe('0')

    });

    test("Check that Ans method setts back to prev answer", async () => {
        const wrapper = mount(calculator, {
            data() {
                return {
                    prev_eq: '111'
                }
            }
        });
        const displayText = wrapper.find('.a');
        const ans = wrapper.find('.c');
        expect(displayText.element.textContent).toBe('0')

        await ans.trigger("click");
        expect(displayText.element.textContent).toBe('111')

    });

    test("Check that delete method deletes the last letter", async () => {
        const wrapper = mount(calculator, {
            data() {
                return {
                    curr_eq: '123'
                }
            }
        });
        const displayText = wrapper.find('.a');
        const del = wrapper.find('.d');

        await del.trigger("click");
        expect(displayText.element.textContent).toBe('12')
    });
});