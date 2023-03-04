import sys
from transformers import pipeline, GPT2TokenizerFast, TFGPT2LMHeadModel

input = sys.argv[1]

tokenizer = GPT2TokenizerFast.from_pretrained('dbmdz/german-gpt2', bos_token='<|startoftext|>',
                                              eos_token='<|endoftext|>')
model = TFGPT2LMHeadModel.from_pretrained('dbmdz/german-gpt2')

tokenizer.add_special_tokens({'pad_token': '[PAD]'})
tokenizer.add_special_tokens({'sep_token': '<|sep|>'})

model.resize_token_embeddings(len(tokenizer))
model.load_weights("/usr/src/app/src/main/java/alphashk/chatbot/python/data/models/2023-02-25_2016_GPT2-Model_02_4.8193.ckpt")

ask = pipeline("text-generation", model=model, tokenizer=tokenizer)

answer = ask(input, max_new_tokens=20)

print(answer[0]['generated_text'][len(input):].strip())
