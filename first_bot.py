import discord
from discord.ext import commands
import random

description = '''My first DiscordBot'''

bot = commands.Bot(command_prefix='??', description=description)

@bot.event
async def on_ready():
  print('Logged in')
  print(bot.user.name)
  print(bot.user.id)
  print('------')
  print('Hello World')
  
@bot.command()
async def add(integerA : int, integerB : int):
  await bot.say(integerA + integerB)
  
@bot.command()
async def subtract(integerA : int, integerB : int):
  await bot.say(integerA - integerB)
  
@bot.command()
async def multiply(integerA : int, integerB : int):
  await bot.say(integerA * integerB)
    
@bot.command()
async def divide(integerA : int, integerB : int):
  await bot.say(integerA / integerB)
  
bot.run('token')
