/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
	ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
		int thisCarry = 0;
		int lastCarry = 0;
		int low = 0;
		int plus = 0;

		bool first = true;

		vector<int> v;

		while (l1 != NULL && l2 != NULL)
		{
			plus = l1->val + l2->val + lastCarry;
			thisCarry = plus / 10;
			low = plus % 10;

			if (first)
			{
				v.push_back(low);
				first = false;
			}
			else if (lastCarry + low > 10)
			{
				v.push_back(low);
			}
			else
			{
				v.push_back(low);
			}

			lastCarry = thisCarry;

			l1 = l1->next;
			l2 = l2->next;
		}

		while (l1 != NULL)
		{
			plus = lastCarry + l1->val;
			v.push_back(plus % 10);
			if (plus >= 10)
			{
				lastCarry = 1;
			}
			else
			{
				lastCarry = 0;
			}
			l1 = l1->next;
		}

		while (l2 != NULL)
		{
			plus = lastCarry + l2->val;
			v.push_back(plus % 10);
			if (plus >= 10)
			{
				lastCarry = 1;
			}
			else
			{
				lastCarry = 0;
			}
			l2 = l2->next;
		}

		if (lastCarry)
		{
			v.push_back(1);
		}

		ListNode *head = new ListNode(v[0]);
		ListNode *l = head;

		for (int i = 1; i < v.size(); i++)
		{
			l->next = new ListNode(v[i]);
			l = l->next;
		}
		return head;
	}
};