import { mount } from "@vue/test-utils";
import { describe, test, expect } from "vitest";
import feedbackForm from "@/components/FeedbackForm.vue";

describe("Form", () => {

    test("Form displays name, email and message inputs", () => {
        const wrapper = mount(feedbackForm);
        const nameInput = wrapper.find('#nameInput');
        const emailInput = wrapper.find('#emailInput');
        const messageInput = wrapper.find('#messageInput');
        expect(nameInput.exists()).toBe(true);
        expect(emailInput.exists()).toBe(true);
        expect(messageInput.exists()).toBe(true);
    });

});